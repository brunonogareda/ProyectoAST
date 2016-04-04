/**
 * GotenMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.0  Built on : Jan 18, 2016 (09:41:27 GMT)
 */
package org.apache.ws.axis2;


/**
 *  GotenMessageReceiverInOut message receiver
 */
public class GotenMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver {
    public void invokeBusinessLogic(
        org.apache.axis2.context.MessageContext msgContext,
        org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault {
        try {
            // get the implementation class for the Web Service
            Object obj = getTheImplementationObject(msgContext);

            GotenSkeleton skel = (GotenSkeleton) obj;

            //Out Envelop
            org.apache.axiom.soap.SOAPEnvelope envelope = null;

            //Find the axisOperation that has been set by the Dispatch phase.
            org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext()
                                                                      .getAxisOperation();

            if (op == null) {
                throw new org.apache.axis2.AxisFault(
                    "Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
            }

            java.lang.String methodName;

            if ((op.getName() != null) &&
                    ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(
                            op.getName().getLocalPart())) != null)) {
                if ("realizarApuestaPartido".equals(methodName)) {
                    org.apache.ws.axis2.RealizarApuestaPartidoResponse realizarApuestaPartidoResponse17 =
                        null;
                    org.apache.ws.axis2.RealizarApuestaPartido wrappedParam = (org.apache.ws.axis2.RealizarApuestaPartido) fromOM(msgContext.getEnvelope()
                                                                                                                                            .getBody()
                                                                                                                                            .getFirstElement(),
                            org.apache.ws.axis2.RealizarApuestaPartido.class);

                    realizarApuestaPartidoResponse17 = skel.realizarApuestaPartido(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            realizarApuestaPartidoResponse17, false,
                            new javax.xml.namespace.QName(
                                "http://ws.apache.org/axis2",
                                "realizarApuestaPartidoResponse"));
                } else
                 if ("comprobarApuestaPichichi".equals(methodName)) {
                    org.apache.ws.axis2.ComprobarApuestaPichichiResponse comprobarApuestaPichichiResponse19 =
                        null;
                    org.apache.ws.axis2.ComprobarApuestaPichichi wrappedParam = (org.apache.ws.axis2.ComprobarApuestaPichichi) fromOM(msgContext.getEnvelope()
                                                                                                                                                .getBody()
                                                                                                                                                .getFirstElement(),
                            org.apache.ws.axis2.ComprobarApuestaPichichi.class);

                    comprobarApuestaPichichiResponse19 = skel.comprobarApuestaPichichi(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            comprobarApuestaPichichiResponse19, false,
                            new javax.xml.namespace.QName(
                                "http://ws.apache.org/axis2",
                                "comprobarApuestaPichichiResponse"));
                } else
                 if ("realizarApuestaPichichi".equals(methodName)) {
                    org.apache.ws.axis2.RealizarApuestaPichichiResponse realizarApuestaPichichiResponse21 =
                        null;
                    org.apache.ws.axis2.RealizarApuestaPichichi wrappedParam = (org.apache.ws.axis2.RealizarApuestaPichichi) fromOM(msgContext.getEnvelope()
                                                                                                                                              .getBody()
                                                                                                                                              .getFirstElement(),
                            org.apache.ws.axis2.RealizarApuestaPichichi.class);

                    realizarApuestaPichichiResponse21 = skel.realizarApuestaPichichi(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            realizarApuestaPichichiResponse21, false,
                            new javax.xml.namespace.QName(
                                "http://ws.apache.org/axis2",
                                "realizarApuestaPichichiResponse"));
                } else
                 if ("comprobarApuestaPartido".equals(methodName)) {
                    org.apache.ws.axis2.ComprobarApuestaPartidoResponse comprobarApuestaPartidoResponse23 =
                        null;
                    org.apache.ws.axis2.ComprobarApuestaPartido wrappedParam = (org.apache.ws.axis2.ComprobarApuestaPartido) fromOM(msgContext.getEnvelope()
                                                                                                                                              .getBody()
                                                                                                                                              .getFirstElement(),
                            org.apache.ws.axis2.ComprobarApuestaPartido.class);

                    comprobarApuestaPartidoResponse23 = skel.comprobarApuestaPartido(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            comprobarApuestaPartidoResponse23, false,
                            new javax.xml.namespace.QName(
                                "http://ws.apache.org/axis2",
                                "comprobarApuestaPartidoResponse"));
                } else {
                    throw new java.lang.RuntimeException("method not found");
                }

                newMsgContext.setEnvelope(envelope);
            }
        } catch (java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    //
    private org.apache.axiom.om.OMElement toOM(
        org.apache.ws.axis2.RealizarApuestaPartido param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(org.apache.ws.axis2.RealizarApuestaPartido.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        org.apache.ws.axis2.RealizarApuestaPartidoResponse param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(org.apache.ws.axis2.RealizarApuestaPartidoResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        org.apache.ws.axis2.ComprobarApuestaPichichi param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(org.apache.ws.axis2.ComprobarApuestaPichichi.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        org.apache.ws.axis2.ComprobarApuestaPichichiResponse param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(org.apache.ws.axis2.ComprobarApuestaPichichiResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        org.apache.ws.axis2.RealizarApuestaPichichi param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(org.apache.ws.axis2.RealizarApuestaPichichi.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        org.apache.ws.axis2.RealizarApuestaPichichiResponse param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(org.apache.ws.axis2.RealizarApuestaPichichiResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        org.apache.ws.axis2.ComprobarApuestaPartido param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(org.apache.ws.axis2.ComprobarApuestaPartido.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        org.apache.ws.axis2.ComprobarApuestaPartidoResponse param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(org.apache.ws.axis2.ComprobarApuestaPartidoResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        org.apache.ws.axis2.RealizarApuestaPartidoResponse param,
        boolean optimizeContent, javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    org.apache.ws.axis2.RealizarApuestaPartidoResponse.MY_QNAME,
                    factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.ws.axis2.RealizarApuestaPartidoResponse wraprealizarApuestaPartido() {
        org.apache.ws.axis2.RealizarApuestaPartidoResponse wrappedElement = new org.apache.ws.axis2.RealizarApuestaPartidoResponse();

        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        org.apache.ws.axis2.ComprobarApuestaPichichiResponse param,
        boolean optimizeContent, javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    org.apache.ws.axis2.ComprobarApuestaPichichiResponse.MY_QNAME,
                    factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.ws.axis2.ComprobarApuestaPichichiResponse wrapcomprobarApuestaPichichi() {
        org.apache.ws.axis2.ComprobarApuestaPichichiResponse wrappedElement = new org.apache.ws.axis2.ComprobarApuestaPichichiResponse();

        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        org.apache.ws.axis2.RealizarApuestaPichichiResponse param,
        boolean optimizeContent, javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    org.apache.ws.axis2.RealizarApuestaPichichiResponse.MY_QNAME,
                    factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.ws.axis2.RealizarApuestaPichichiResponse wraprealizarApuestaPichichi() {
        org.apache.ws.axis2.RealizarApuestaPichichiResponse wrappedElement = new org.apache.ws.axis2.RealizarApuestaPichichiResponse();

        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        org.apache.ws.axis2.ComprobarApuestaPartidoResponse param,
        boolean optimizeContent, javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    org.apache.ws.axis2.ComprobarApuestaPartidoResponse.MY_QNAME,
                    factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.ws.axis2.ComprobarApuestaPartidoResponse wrapcomprobarApuestaPartido() {
        org.apache.ws.axis2.ComprobarApuestaPartidoResponse wrappedElement = new org.apache.ws.axis2.ComprobarApuestaPartidoResponse();

        return wrappedElement;
    }

    /**
     *  get the default envelope
     */
    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory) {
        return factory.getDefaultEnvelope();
    }

    private java.lang.Object fromOM(org.apache.axiom.om.OMElement param,
        java.lang.Class type) throws org.apache.axis2.AxisFault {
        try {
            if (org.apache.ws.axis2.ComprobarApuestaPartido.class.equals(type)) {
                return org.apache.ws.axis2.ComprobarApuestaPartido.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (org.apache.ws.axis2.ComprobarApuestaPartidoResponse.class.equals(
                        type)) {
                return org.apache.ws.axis2.ComprobarApuestaPartidoResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (org.apache.ws.axis2.ComprobarApuestaPichichi.class.equals(type)) {
                return org.apache.ws.axis2.ComprobarApuestaPichichi.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (org.apache.ws.axis2.ComprobarApuestaPichichiResponse.class.equals(
                        type)) {
                return org.apache.ws.axis2.ComprobarApuestaPichichiResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (org.apache.ws.axis2.RealizarApuestaPartido.class.equals(type)) {
                return org.apache.ws.axis2.RealizarApuestaPartido.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (org.apache.ws.axis2.RealizarApuestaPartidoResponse.class.equals(
                        type)) {
                return org.apache.ws.axis2.RealizarApuestaPartidoResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (org.apache.ws.axis2.RealizarApuestaPichichi.class.equals(type)) {
                return org.apache.ws.axis2.RealizarApuestaPichichi.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (org.apache.ws.axis2.RealizarApuestaPichichiResponse.class.equals(
                        type)) {
                return org.apache.ws.axis2.RealizarApuestaPichichiResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }
        } catch (java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

        return null;
    }

    private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
        org.apache.axis2.AxisFault f;
        Throwable cause = e.getCause();

        if (cause != null) {
            f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
        } else {
            f = new org.apache.axis2.AxisFault(e.getMessage());
        }

        return f;
    }
} //end of class