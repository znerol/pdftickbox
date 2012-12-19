PDF Box Ticking Service
=======================

This project is a proof of concept implementing a Java Webapp capable of
filling out PDF forms based on XFDF documents.

The code is based on [Spring] 3.1 and [Apache PDFBox] 1.7.1. The file
PDFFormFiller.java holds the interesting bits.

[Spring]: http://www.springsource.org/
[Apache PDFBox]: http://pdfbox.apache.org/

Installation
------------

Build using Maven

    mvn package

Then grab the war file in `target/pdftickbox-1.0.0-BUILD-SNAPSHOT.war` and
deploy it into your application server. Note that you have to supply
`pdftickbox.template.directory=/path/to/dir/holding/some/pdfs` e.g. as a Java
property (`-Dpdftickbox.temp...`) or as a `context-param`.

License
-------

This code is released under the MIT license.
