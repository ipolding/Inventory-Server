package ipolding.co.uk.xml;

import org.w3c.dom.Node;

/**
 * Created by ian.polding on 15/05/2014.
 */
public class DOMEchoExample {

    static void echo (Node n) {
        final int type = n.getNodeType();
        switch (type) {
            case Node.DOCUMENT_NODE: System.out.println ("DOC:"); break;
            case Node.DOCUMENT_TYPE_NODE: System.out.println ("DOC_TYPE:"); break;
            case Node.ELEMENT_NODE: System.out.println ("ELEM:"); break;
            case Node.TEXT_NODE: System.out.println ("TEXT:"); break;
            default:  System.out.print ("other node:  " + type);
                break;
        }
        System.out.print (" nodeName=\"" + n.getNodeName() + "\"");
        final String val = n.getNodeValue();
        if (val != null && !(val.trim().equals(""))) {
            System.out.println (" nodeValue \"" + n.getNodeValue() +"\"");
        }
        System.out.println ();

        for (Node child = n.getFirstChild(); child !=null; child=child.getNextSibling()) {
            echo (child);
        }
    }

}
