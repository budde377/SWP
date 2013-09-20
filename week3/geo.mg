<?xml version="1.0"?>
<grammar xmlns="http://relaxng.org/ns/structure/1.0">
    <start>
	<element name="point">
		    <choice>
			<interleave>
			    <zeroOrMore>
			        <ref name="note" />
			    </zeroOrMore>
			    <ref name="address" />
			</interleave>
			<interleave>
			    <zeroOrMore>
			        <ref name="note" />
			    </zeroOrMore>
			        <ref name="latitude" />
				<ref name="longitude" />
			</interleave>
		    </choice>
	</element>
    </start>
    <define name="note">
        <element name="note"><text /></element>
    </define>
    <define name="longitude">
  	<element name="longitude"><text /></element>
    </define>
    <define name="latitude">
  	<element name="latitude"><text /></element>
    </define>
    <define name="address">
  	<element name="address"><text /></element>
    </define>
</grammar>