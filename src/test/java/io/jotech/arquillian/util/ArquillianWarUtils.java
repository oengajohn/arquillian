package io.jotech.arquillian.util;


import java.io.File;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.jboss.shrinkwrap.resolver.api.maven.archive.importer.MavenImporter;

public class ArquillianWarUtils {
    private static final String ASSERTJ_COORDINATE =
            "org.assertj:assertj-core";

    private static final File[] ASSERTJ_ARTIFACT = Maven.resolver()
            .loadPomFromFile("pom.xml")
            .resolve(ASSERTJ_COORDINATE)
            .withTransitivity().asFile();



    public static WebArchive getBasicWebArchive() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addAsLibraries(ASSERTJ_ARTIFACT)
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");

    }



    public static WebArchive importBuildOutput() {
        return ShrinkWrap.create(MavenImporter.class).loadPomFromFile("pom.xml")
                .importBuildOutput()
                .as(WebArchive.class);
    }
}
