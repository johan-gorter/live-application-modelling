package org.instantlogic.netty.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;

import javax.management.RuntimeErrorException;

import org.instantlogic.fabric.Instance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CasePersister {

	private static final Logger logger = LoggerFactory.getLogger(CasePersister.class);
	
	public static final CasePersister INSTANCE = new CasePersister();
	
	private CasePersister() {
	}

	public static final Gson gson = new GsonBuilder()
			.setDateFormat("yyyy-MM-dd")
			.setPrettyPrinting()
			.registerTypeHierarchyAdapter(Instance.class, new GsonInstanceAdapter()).create();

	private static final File casesDir;
	static {
		casesDir = new File("cases");
		casesDir.mkdirs();
	}

	public void persist(String id, Instance caseInstance, int version) {
		try {
			caseInstance.getMetadata().getCaseAdministration().setVersion(version);
			File file = new File(casesDir, id + ".tmp");
			FileOutputStream stream = new FileOutputStream(file);
			OutputStreamWriter writer = new OutputStreamWriter(stream, "UTF-8");
			gson.toJson(caseInstance, writer);
			writer.close();
			File targetFile = new File(casesDir, id + ".json");
			if (targetFile.exists()) {
				targetFile.delete();
			}
			file.renameTo(targetFile);
			logger.info("Persisted "+id+" version "+version);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public <T extends Instance> T load(String id, Class<T> ofType) {
		T result = null;
		try {
			File file = new File(casesDir, id + ".json");
			FileInputStream stream = new FileInputStream(file);
			InputStreamReader reader = new InputStreamReader(stream, "UTF-8");
			result = gson.fromJson(reader, ofType);
			reader.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return result;
	}

	private static final Random random = new Random();

	public static String uniqueId() {
		byte[] bytes = new byte[8];
		random.nextBytes(bytes);
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<bytes.length;i++) {
			sb.append(Integer.toHexString(bytes[i]/16));
			sb.append(Integer.toHexString(bytes[i]%16));
		}
		return sb.toString();
	}

	public Instance loadOrCreate(String caseId, Class<? extends Instance> ofType) {
		File file = new File(casesDir, caseId + ".json");
		if (file.exists()) {
			return load(caseId, ofType);
		} else {
			try {
				Instance result = ofType.newInstance();
				persist(caseId, result, 1);
				return result;
			} catch (InstantiationException | IllegalAccessException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
