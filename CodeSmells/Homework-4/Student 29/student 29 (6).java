package omok.gui;

/**
 *  @author Christian Revilla
 *	Created February 20th 2023
 */

/** Represents the Omok Players */ 
public class OmokPlayer {
  private String name;
  private Boolean human;

  /** Default Constructor */
  public OmokPlayer () {
  }
  
  /** Constructor when passed String name */
  public OmokPlayer ( String name ) {
    this.name = name;
  }

  /** Constructor when passed String and if human player */
  public OmokPlayer ( String name, Boolean h ) {
    this.name = name;
    this.human = h;

  }

  /** @return String name of player */
  public String getPlayerName () {
    return this.name;
  }

  /** @return Boolean if player is human */
  public Boolean getPlayerType () {
    return this.human;
  }

  /** @param String sets String passed to players name */
  public void setPlayerName ( String name ) {
    this.name = name;
  }

  /** @param Boolean sets Boolean passed to distinguish player type */
  public void setPlayerType ( Boolean t) {
    this.human = t;
  }
}
