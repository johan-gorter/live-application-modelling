package org.instantlogic.designer.codegenerator.generator;

import java.util.ArrayList;
import java.util.List;

import org.instantlogic.designer.codegenerator.classmodel.ApplicationClassModel;
import org.instantlogic.designer.codegenerator.classmodel.EntityClassModel;
import org.instantlogic.designer.codegenerator.classmodel.EventClassModel;
import org.instantlogic.designer.codegenerator.classmodel.FlowClassModel;
import org.instantlogic.designer.codegenerator.classmodel.PlaceClassModel;
import org.instantlogic.designer.codegenerator.classmodel.SharedPageFragmentClassModel;
import org.instantlogic.designer.codegenerator.classmodel.SubFlowClassModel;

public class GeneratedClassModels {

	public final List<EntityClassModel> updatedEntities = new ArrayList<EntityClassModel>();

	public final List<EntityClassModel> deletedEntities = new ArrayList<EntityClassModel>();
	
	public final List<SharedPageFragmentClassModel> updatedSharedPageFragments = new ArrayList<SharedPageFragmentClassModel>();

	public final List<SharedPageFragmentClassModel> deletedSharedPageFragments = new ArrayList<SharedPageFragmentClassModel>();

	public final List<EventClassModel> updatedEvents = new ArrayList<EventClassModel>();

	public final List<EventClassModel> deletedEvents = new ArrayList<EventClassModel>();
	
	public final List<FlowClassModel> updatedFlows = new ArrayList<FlowClassModel>();

	public final List<FlowClassModel> deletedFlows = new ArrayList<FlowClassModel>();
	
	public final List<PlaceClassModel> updatedPages = new ArrayList<PlaceClassModel>();

	public final List<PlaceClassModel> deletedPages = new ArrayList<PlaceClassModel>();
	
	public final List<SubFlowClassModel> updatedSubFlows = new ArrayList<SubFlowClassModel>();

	public final List<SubFlowClassModel> deletedSubFlows = new ArrayList<SubFlowClassModel>();
	
	public ApplicationClassModel updatedApplication = null;
	
	public String rootPackageName;
}
