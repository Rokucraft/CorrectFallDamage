# CorrectFallDamage ![License](https://img.shields.io/github/license/Rokucraft/CorrectFallDamage)

CorrectFallDamage is a Paper plugin that aims to correct fall damage for entities that have a negative level of Jump Boost applied to them.\
Negative levels of Jump Boost can be used to limit or even entirely prevent jumping, but that causes entities to take additional fall damage, even from falls that would normallly do no damage. 
This plugin prevents that from happening, so the Jump Boost status effect can freely be used to limit jumping without having to worry about changes in fall damage. Positive levels of Jump Boost are **not** affected.
 
## Installation
Simply drag and drop the plugin jar into your plugins folder and start your server!

## Building
To build CorrectFallDamage, clone the repository and build the plugin with Gradle by running the following command:
```
./gradlew build
```
