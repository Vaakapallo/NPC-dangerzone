package ambassador;

import java.io.IOException;

public class TestMain {

    public static void main(String[] args) throws IOException {
        Bibwriter b = new Bibwriter();
        String jotain = "@INPROCEEDINGS{inproceedings-minimal,"
                + "\nauthor = \"Alfred V. Oaho and Jeffrey D. Ullman and Mihalis Yannakakis\","
                + "\ntitle = \"On Notions of Information Transfer in {VLSI} Circuits\","
                + "\nbooktitle = \"Proc. Fifteenth Annual ACM\" # STOC,"
                + "\nyear = 1983,"
                + "\n}";

        b.writeReference(jotain);
    }
}
