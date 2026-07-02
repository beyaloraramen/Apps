# ----------------------------------------------------------------------------
# General R8/ProGuard Optimizations
# ----------------------------------------------------------------------------
# Prevent removing unused resources/code that might be called via reflection
-dontwarn javax.annotation.**
-keepattributes InnerClasses,EnclosingMethod,SourceFile,LineNumberTable

# ----------------------------------------------------------------------------
# Room Database (Keeps generated database classes)
# ----------------------------------------------------------------------------
-keep class * extends androidx.room.RoomDatabase
-keep class * extends androidx.room.RoomMasterTable
-keep class * extends androidx.sqlite.db.SupportSQLiteOpenHelper$Callback

# ----------------------------------------------------------------------------
# Hilt (Dependency Injection)
# ----------------------------------------------------------------------------
-keep class dagger.hilt.android.internal.managers.* { *; }
-keep class * implements dagger.hilt.internal.GeneratedComponent { *; }
-keep class * extends dagger.hilt.internal.GeneratedComponentManager { *; }

# ----------------------------------------------------------------------------
# Gson (Keep names of classes)
# ----------------------------------------------------------------------------
-keepattributes Signature
-keepattributes *Annotation*
-keep class com.google.gson.** { *; }

# Keep data model classes
-keep class com.ramen.apps.model.** { *; }

# ----------------------------------------------------------------------------
# Shizuku (Preserve API interfaces)
# ----------------------------------------------------------------------------
-keep interface rikka.shizuku.** { *; }