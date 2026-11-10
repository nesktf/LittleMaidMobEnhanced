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

## Maidpacks and sounds
Maidpack discovery is re enabled in this version. Just drag and drop maidpack zip files in either
`.minecraft/maidpacks` or `.minecraft/mods/littleMaidMob` if you prefer the legacy folder. By
default the mod only exposes the original littleMaidMob models. The mod has the original
littleMaidMob sound pack built in already.

This fork supports using the bedrock model format from TouhouLittleMaid, see the extra
maidpacks in `maidpacks/tlm_*` for some examples.

Check the original [TouhouLittleMaid](https://github.com/TartaricAcid/TouhouLittleMaid) project
for their models' credits and their usage licenses.

## Planned features
- [X] Fix some minor bugs from the original LittleMaidMobEnhanced.
- [X] Add missing meidos textures.
- [X] Migrate gradle build scripts to [updated GTNH versions](https://github.com/GTNewHorizons/ExampleMod1.7.10).
- [X] Re-enable external maidpacks.
- [X] Backport models from TouhouLittleMaid.
- [ ] Support external soundpacks again.
- [ ] Add a script or something to make porting bedrock models easier.
- [ ] Backport more features from TouhouLittleMaid.
- [ ] ???

## Building
Before building anything, you will need to install a java 25 SDK. I recommend using
[SDKMAN!](https://sdkman.io/) or downloading one from your favorite software repository.

```sh
$ sdk install java 25.0.1-tem
```

After that, just run the gradlew script (or build using your preferred IDE):
```sh
$ ./gradlew setupDecompWorkspace
$ ./gradlew build
$ ./gradlew buildMaidPacks # for extra maidpacks
```

The mod jar and the extra maidpacks should be saved in `build/lib` after building.
