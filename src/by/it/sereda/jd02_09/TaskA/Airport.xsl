<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/Airport">
        <table border="1" width="500px">
            <tr>
                <td colspan="3" align="center">Airport</td>
            </tr>
            <tr>
                <td>Administrator</td>
                <td>Flight</td>
                <td>Dispatcher</td>
            </tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/Airport/Administrator">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/Airport/Flight">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/Airport/Dispatcher">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/Airport/BrigadeList">
        <table border="1" width="500px">
            <tr>
                <td colspan="3" align="center">BrigadeList</td>
            </tr>
            <tr>
                <td>Pilot</td>
                <td>Navigator</td>
                <td>Stewardess</td>
            </tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/Airport/BrigadeList/Brigade">
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>

    <xsl:template match="/Airport/BrigadeList/Brigade/Pilot">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/Airport/BrigadeList/Brigade/Navigator">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/Airport/BrigadeList/Brigade/Stewardess">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

</xsl:stylesheet>