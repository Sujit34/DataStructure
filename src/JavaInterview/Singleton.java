package JavaInterview;

public class Singleton {
	public static Singleton single_tone = null;

	public String s;

	public Singleton() {
		s = "Hello";
	}

	public static synchronized Singleton getInstance() {
		if (single_tone == null) {
			single_tone = new Singleton();
		}
		return single_tone;
	}

	public static void main(String args[]) {
		Singleton x = Singleton.getInstance();
	}

}
