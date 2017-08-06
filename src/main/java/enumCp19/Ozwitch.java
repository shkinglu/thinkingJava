package enumCp19;

public enum Ozwitch {
	
	WEST("Miss Gluch"),East("Glinda"),South("Good by"),North("Wicked");
	
	private String description;
	private Ozwitch(String description) {
		this.description=description;
	}
}
