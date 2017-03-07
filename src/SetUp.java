import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SetUp {
		
	public static List<Task> createTaskList() {
		String file = "resource/task-events.txt";
		List<Task> taskList = new ArrayList<Task>();
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    int i = 0;
		    while ((line = br.readLine()) != null && i < 10) {
		       System.out.println(line);
		       i++;
		    }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<PC> createPCList() {
		List<PC> list = new ArrayList<PC>();
		for (int i = 0; i < 16000; i++) {
			list.add(new PC());
		}
		return list;
	}

}
