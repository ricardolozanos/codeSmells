package balloon;
/**
 *
 * @param <Balloon> Allows for subclasses to choose which classes to instantiate.
 */
public interface Balloon<Balloon>{
     /**
      *
      * @return new type of Balloon.
      */
     Balloon createBalloon();
}
