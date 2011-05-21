package lbe.page;

public class Page {
	
	private PageElement structure;
	private int caseVersion;
	
	public PageElement getStructure() {
		return structure;
	}
	public void setStructure(PageElement structure) {
		this.structure = structure;
	}
	public int getCaseVersion() {
		return caseVersion;
	}
	public void setCaseVersion(int caseVersion) {
		this.caseVersion = caseVersion;
	}
}
