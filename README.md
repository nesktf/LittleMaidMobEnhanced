# LittleMaidMobEnhanced

![banner](src/main/resources/assets/lmmx/banner.png)

LittleMaidMob is a mod that adds LittleMaids to your world that you can hire to do a variety of
tasks for you.

This is a fork of [LittleMaidMobEnhanced](https://github.com/Goujer/LittleMaidMobEnhanced) that
aims to make a "definitive" version of LittleMaidMob for more recent modpacks (like GTNH), using
more up to date build scripts and maybe including some additional functionalities.

> [!NOTE]
> If you are moving from another version (including the original LittleMaidMobEnhanced),
> make sure to backup your world and/or meidos NBT data before trying this version. I'm not
> responsible for any damages caused by this mod.

## Planned features
- [X] Fix some minor bugs from the original LittleMaidMobEnhanced
- [X] Add missing meidos textures
- [X] Migrate gradle build scripts to [updated GTNH versions](https://github.com/GTNewHorizons/ExampleMod1.7.10)
- [ ] Backport models from [Touhou Little Maid](https://github.com/TartaricAcid/TouhouLittleMaid)
- [ ] ???

## Building
Before building anything, yo will need to install a java 25 SDK. I recommend using
[SDKMAN!](https://sdkman.io/) or downloading one from your favorite software repository.

```sh
$ sdk install java 25.0.1-tem
```

Then just run the gradlew script or build using your preferred IDE
```sh
$ ./gradlew setupDecompWorkspace
$ ./gradlew build
```
