/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fields;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lauri
 */
public class Pages implements Field {

    private List<PageCollection> pages;

    public Pages(int... pagenumbers) {
        pages = new ArrayList();
        for (int i = 0; i < pagenumbers.length; i = i+2) {
            if (i != pagenumbers.length - 1) {
                if (pagenumbers[i] > 0 && pagenumbers[i + 1] > 0) {
                    pages.add(new PageCollection(pagenumbers[i], pagenumbers[i + 1]));
                }
            }
        }
    }

    @Override
    public String toString() {
        String returnString = "pages = { ";
        for (int i = 0; i < pages.size(); i++) {
            String tempString;
            if(pages.get(i).startPage != pages.get(i).endPage) {
            tempString = pages.get(i).startPage + "--" + pages.get(i).endPage;
            } else {
                tempString = "" + pages.get(i).startPage;
            } if (i != pages.size() - 1) {
                tempString = tempString + ", ";
            }
            returnString = returnString + tempString;
        }
        returnString = returnString + "},\n";
        return returnString;
    }

    @Override
    public String getField() {
        String resString = "";
        for (PageCollection pageCollection : pages) {
            resString = resString + pageCollection;
        }
        return resString;
    }

    private class PageCollection {

        private int startPage;
        private int endPage;

        public PageCollection(int startPage, int endPage) {
            if (startPage > 0 && endPage > 0) {
                this.startPage = Math.min(startPage, endPage);
                this.endPage = Math.max(startPage, endPage);
            } else {
                this.startPage = -1;
                this.endPage = -1;
            }
        }

        public int getStartPage() {
            return startPage;
        }

        public int getEndPage() {
            return endPage;
        }
        @Override
        public String toString() {
            if (startPage != endPage) {
                return "[" + startPage + ", " + endPage + "] ";
            } else {
                return "[" + startPage +"] ";
            }
        }
    }
}
