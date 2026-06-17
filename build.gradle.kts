
plugins {
    id("com.gtnewhorizons.gtnhconvention")
}

//archivesBaseName = "LittleMaidMobEnhanced"

jar {
  manifest {
    attributes 'FMLCorePlugin': 'littleMaidMobX.util.transform.CoreMod',
               'FMLCorePluginContainsFMLMod': 'true'
  }
}
