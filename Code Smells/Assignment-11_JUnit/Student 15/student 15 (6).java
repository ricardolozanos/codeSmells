import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class UUIDGenerator {

    public static UUID generateUUIDFromComputerInfo() {
        try {
            InetAddress address = InetAddress.getLocalHost();
            String hostName = address.getHostName();
            String hostAddress = address.getHostAddress();

            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(hostName.getBytes());
            messageDigest.update(hostAddress.getBytes());

            byte[] hashBytes = messageDigest.digest();
            String hashString = bytesToHex(hashBytes);

            return UUID.nameUUIDFromBytes(hashString.getBytes());
        } catch (UnknownHostException | NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }
}
