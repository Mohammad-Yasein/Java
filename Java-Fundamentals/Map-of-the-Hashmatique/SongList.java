import java.util.HashMap;
import java.util.Set;

public class SongList {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("Nine Inch Nails", "Hurt");
        trackList.put("Joy Division", "Love Will Tear Us Apart");
        trackList.put("Arcade Fire", "Sprawl II Mountains Beyond Mountains");
        trackList.put("Beyonce", "Formation");

        System.out.println(trackList.get("Arcade Fire"));

        Set<String> keys = trackList.keySet();
        for (String key : keys) {
            System.out.println(key + " : " + trackList.get(key));
        }
    }
}
