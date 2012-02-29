package lbe.engine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;

import org.apache.commons.codec.binary.Hex;
import org.apache.log4j.Logger;
import org.instantlogic.fabric.Instance;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CasePersister {

	private static final Logger LOG = Logger.getLogger(CasePersister.class);
	
	public static final CasePersister INSTANCE = new CasePersister();
	
	private CasePersister() {
	}

	public static final Gson gson = new GsonBuilder()
			.setDateFormat("yyyy-MM-dd")
			.setPrettyPrinting()
			.registerTypeHierarchyAdapter(Instance.class,
					new GsonInstanceAdapter()).create();

	private static final File sessionsDir;
	static {
		if (new File("lberunner").isDirectory()) {
			sessionsDir = new File("lberunner/sessions");
		} else {
			sessionsDir = new File("sessions");
		}
		sessionsDir.mkdirs();
	}

	public void persist(String id, Instance<?> caseInstance, int version) {
		try {
			caseInstance.getInstanceAdministration().setVersion(version);
			File file = new File(sessionsDir, id + ".tmp");
			FileOutputStream stream = new FileOutputStream(file);
			OutputStreamWriter writer = new OutputStreamWriter(stream, "UTF-8");
			gson.toJson(caseInstance, writer);
			writer.close();
			File targetFile = new File(sessionsDir, id + ".json");
			if (targetFile.exists()) {
				targetFile.delete();
			}
			file.renameTo(targetFile);
			LOG.info("Persisted "+id+" version "+version);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public <T extends Instance<T>> T load(String id, Class<T> ofType) {
		T result = null;
		try {
			File file = new File(sessionsDir, id + ".json");
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
		return Hex.encodeHexString(bytes);
	}
}
