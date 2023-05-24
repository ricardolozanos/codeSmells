package omok.gui;

/**
 *  @author Christian Revilla
 *	Created February 20th 2023
 */

/** Controller class to create and start Omok game */
public class OmokControl {

	/**@return OmokGame instance intended for console version */
	public OmokGame createGame() {
		return new OmokGame();
	}
	
	/** @return OmokGuiRun, Gui version of Omok */
	public OmokGuiRun createGuiGame() {
		return new OmokGuiRun(15,true);
	}
	
	/** Starts the application */
	public void start() {
		// Console version 
		//OmokGame game = createGame();
		//game.startOmokGame();
		
		// Gui version
		createGuiGame();
	}
	
	
}

