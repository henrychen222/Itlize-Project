
package com.easylearn;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.easylearn package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _WishUserResponse_QNAME = new QName("http://easylearn.com/", "wishUserResponse");
    private final static QName _WishUser_QNAME = new QName("http://easylearn.com/", "wishUser");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.easylearn
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link WishUserResponse }
     * 
     */
    public WishUserResponse createWishUserResponse() {
        return new WishUserResponse();
    }

    /**
     * Create an instance of {@link WishUser }
     * 
     */
    public WishUser createWishUser() {
        return new WishUser();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WishUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://easylearn.com/", name = "wishUserResponse")
    public JAXBElement<WishUserResponse> createWishUserResponse(WishUserResponse value) {
        return new JAXBElement<WishUserResponse>(_WishUserResponse_QNAME, WishUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WishUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://easylearn.com/", name = "wishUser")
    public JAXBElement<WishUser> createWishUser(WishUser value) {
        return new JAXBElement<WishUser>(_WishUser_QNAME, WishUser.class, null, value);
    }

}
