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
<xsl:output method="text" indent="no"/>
<xsl:template match="module/param">
<xsl:value-of select="./@name" disable-output-escaping="yes"/>=<xsl:value-of select="." disable-output-escaping="yes"/>

</xsl:template>
</xsl:stylesheet>
