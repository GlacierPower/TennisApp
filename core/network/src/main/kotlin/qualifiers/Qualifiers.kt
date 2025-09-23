package qualifiers

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
internal annotation class Tennis

@Qualifier
@Retention(AnnotationRetention.BINARY)
internal annotation class CountryFlags
