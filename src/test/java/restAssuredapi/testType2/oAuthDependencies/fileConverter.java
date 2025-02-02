package restAssuredapi.testType2.oAuthDependencies;

import java.nio.file.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class fileConverter {

	private boolean verifyFileExicest(String PathOfFile) {
		Path path = Paths.get(PathOfFile);
		try {
			if (Files.exists(path)) {
				Files.delete(path);
				System.out.println(" [INFO]:::OLD FILE DELETED:::");
				return true;
			}
			return true;
		} catch (Exception e) {
			System.out.println(" [INFO]:::FILE VERIFICATION:::" + e.toString());
		}
		return false;
	}

	public void ConvertStringToFile(String Path, String ResponceData) {
		try {
			if (verifyFileExicest(Path)) {
				Thread.sleep(3000);
				Path filePath = Paths.get(Path);
				if (!Files.exists(filePath)) {
					Files.createFile(filePath);
					Files.write(filePath, ResponceData.getBytes(), StandardOpenOption.APPEND);
					System.out.println(" [INFO]:::FILE CREATED WITH RESPONCE:::");
				}
			}
		} catch (Exception e) {
			System.out.println(" [INFO]:::FILE CREATION WITH RESPONCE:::" + e.toString());
		}

	}

}
