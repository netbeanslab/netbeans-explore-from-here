<?xml version="1.0" encoding="UTF-8" ?>
<!--

                          Sun Public License Notice

 The contents of this file are subject to the Sun Public License Version
 1.0 (the "License"). You may not use this file except in compliance with
 the License. A copy of the License is available at http://www.sun.com/

 The Original Code is the "Explore from here" NetBeans Module.
 The Initial Developer of the Original Code is alessandro negrin.
 Portions created by alessandro negrin are Copyright (C) 2005.
 All Rights Reserved.

 Contributor(s): alessandro negrin.


-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="xml" indent="yes" doctype-system="module_updates" doctype-public="-//NetBeans//DTD Autoupdate Catalog 2.3//EN"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/">
<!-- &#60;!DOCTYPE module_updates PUBLIC "-//NetBeans//DTD Autoupdate Catalog 2.3//EN" "http://www.netbeans.org/dtds/autoupdate-catalog-2_3.dtd"&#62; -->
<module_updates timestamp="01/01/01/$DDMMYYYY">
    <module_group name="Infrastructure">
        <xsl:copy-of select="."/>
    </module_group>
</module_updates>
    </xsl:template>

</xsl:stylesheet>
