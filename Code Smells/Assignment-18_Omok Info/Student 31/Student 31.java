
package noapplet.example;

import java.awt.*;
import java.net.URI;

class webpag {
    public static void main(String[] args)
            throws Exception
    {
        Desktop desk = Desktop.getDesktop();

        // now we enter our URL that we want to open in our
        // default browser
        desk.browse(new URI("http://omok.atwebpages.com/info/"));
        System.out.println("accessing to the webpage");
    }
}