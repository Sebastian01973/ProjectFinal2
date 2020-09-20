package persistence;

import models.ManagePatients;

import java.io.IOException;
import java.util.ArrayList;

public interface IFileManager {
	abstract ArrayList<Object> readFile(String name) throws IOException;
	abstract void writeFile(String name, ManagePatients managePatients);
}
