package Question200;
import java.util.*;

public class ImmutableList {
	public static void main(String[] args) {
		List<String> list  = new ArrayList<>();
		list.add("ABC");
		list.add("DEF");
		System.out.println(list);
		List<String> new_list = Collections.unmodifiableList(list);
		list.add("GHI");
		System.out.println(list);
		System.out.println(new_list);		
	}

}
