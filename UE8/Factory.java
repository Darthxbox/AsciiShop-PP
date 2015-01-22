import java.util.Scanner;

public interface Factory {
	//Interface-Methode create wobei ein Objekt des Typs Scanner uebergeben wird.
	public Operation create(Scanner scanner) throws FactoryException;
}
