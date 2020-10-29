public class A2Aligner implements Aligner {
	private String sequence;
	private String lastTested;
	private int numErrors;
	private int offset;
	
	public A2Aligner(String sequence) {
		this.sequence = sequence;
		lastTested = "";
		offset = -1;
		numErrors = -1;
	}
	
	public int errorsAtOffset(int index, String subsequence) {
		char[] dataSequence = sequence.toCharArray();
		char[] toFind = subsequence.toCharArray();
		int errors = toFind.length;

		for (int i = 0; i < toFind.length; i++) {
			if (index + i > dataSequence.length - 1) {
				return errors;
			}
			if (toFind[i] == dataSequence[index + i]) {
				errors--;
			}
		}
		return errors;
	}
			
	public void bestAlignmentOffset(String subsequence) {
		offset = 0;
		numErrors = subsequence.length();
		lastTested = subsequence;

		for (int i = 0; i < sequence.length(); i++) {
			int errs = errorsAtOffset(i, subsequence);
			if (numErrors > errs){
				numErrors = errs;
				offset = i;
			}
		}
	}	
	
	public String toString() {
		String s = 	"Data sequence: " + sequence + "\n";
		s +=		"Compared with: " + lastTested + "\n";
		s +=		"Best index number: "+ offset + "\n";
		s +=		"Errors detected: " + numErrors + "\n";
		return s;
	}

	public String getSequence() {
		return this.sequence;
	}

	public String getLastTested() {
		return this.lastTested;
	}

	public int getOffset() {
		return this.offset;
	}

	public int getNumErrors() {
		return this.numErrors;
	}
}
