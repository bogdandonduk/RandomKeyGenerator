
# RandomKeyGenerator

  A simple utility tool for Android that can generate unique keys. Those are unique numbers with the optional prefixes provided by you or extracted from the name of the calling class. It guarantees the generated keys are unique by evaluating regeneration predicate.
  
## Include in your project  
**Gradle dependency**  
  
Add this in your **app**-level **build.gradle** file:  
```groovy
dependencies {  
	...  
  
	def latest_version_tag = 0.1.0
	implementation "com.github.bogdandonduk:RandomKeyGenerator:$latest_version_tag"  
  
	...  
}  
```  
You can always find the **latest_version_tag** [here](https://github.com/bogdandonduk/RandomKeyGenerator/releases).  
  
Also make sure you have this repository in your **project**-level **build.gradle** file:  
```groovy  
allprojects {  
	repositories {  
		...  
  
		maven { url 'https://jitpack.io' }  
	}  
}  
```  

# Examples of usage
```kotlin 
// gen
val myFirstUniqueKey = "my_key_56839"

val myUniqueKey: String = RandomKeyGenerator.generateWithPrefix("my_key", regenerationPredicate = { attemptKey: String ->
	attemptKey == myFirstUniqueKey 
	// if this will ever happen to be true,
	// another key will be generated
	// but the probability of this ever happening is tiny
	// because the chance is one to billion
})
```
