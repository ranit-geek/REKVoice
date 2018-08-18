package COM.SCISS.REK;

import java.io.IOException;

public class VOICELAUNCHER extends Base {

	public static void main(String[] args) throws IOException {
		SeleniumConfig.getseleniumMigration();
		SphinxConfig.getSphinxConfig();
		ExecuteCommands.executeCommands();

	}

}
