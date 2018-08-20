// ## Ammonite Shell ##
// https://git.io/vHaKQ
interp.load.ivy(
  "com.lihaoyi" %
  s"ammonite-shell_${scala.util.Properties.versionNumberString}" %
  ammonite.Constants.version
)
@
val shellSession = ammonite.shell.ShellSession()
import shellSession._
import ammonite.ops._
import ammonite.shell._
ammonite.shell.Configure(interp, repl, wd)

// ## Misc Setting ##
// Show compiler warnings
interp.configureCompiler(_.settings.nowarnings.value = false)

import $ivy.`com.typesafe:config:1.3.3`
import com.typesafe.config.ConfigFactory

// https://github.com/lihaoyi/Ammonite/issues/472
// Show compiler warnings
interp.configureCompiler(_.settings.nowarnings.value = false)

// default imports
// import $ivy.`com.google.guava:guava:26.0-jre`

// it's already default, check `repl.imports`
// import scala.collection.JavaConverters._

// ## Filesystem Walk ##
import $ivy.`org.scala-sbt:sbt:1.2.1` // file system traverse with sbt.io
// sbt has better file traversal
import sbt.io.PathFinder
import sbt.file

import sbt.io.FileFilter.globFilter // implicit f:String => FileFilter
/*
val finder = PathFinder(file(".")) / "build.sbt"
*/

// Files.walk in Java => os.walk in Python
// https://stackoverflow.com/questions/2637643/how-do-i-list-all-files-in-a-subdirectory-in-scala
import java.nio.file.{FileSystems, Files}
/*
val cwd = FileSystems.getDefault.getPath(".")
Files.walk(pwd.toNIO).iterator().asScala.filter(Files.isRegularFile(_)).foreach(println)
*/

// ## Filesystem Format ##
// CSV
import $ivy.`com.github.tototoshi::scala-csv:1.3.5`

// Json
import $ivy.`org.json4s::json4s-native:3.6.0`
// http://www.lihaoyi.com/post/uJsonfastflexibleandintuitiveJSONforScala.html
import $ivy.`com.lihaoyi::ujson:0.6.6`

// ## Lens ##
import $ivy.`com.github.julien-truffaut::monocle-core:1.5.0`
import $ivy.`com.github.julien-truffaut::monocle-macro:1.5.0`

// ## Macro ##
import $plugin.$ivy.`org.scalamacros:::paradise:2.1.1`

// ## From Bash ##
/*
cd ~  => cd! Path.home
vim ~/.ammonite/pred.sc =>
  val predef = Path.home/ ".ammonite" / "predef.sc"
  %vim predef
source x.sh => interp.load.module("x.sc")
history =>
  repl.history
*/

/**
  * https://github.com/lihaoyi/Ammonite/blob/master/shell/src/main/resources/ammonite/shell/example-predef.sc
  * https://github.com/lihaoyi/Ammonite/blob/master/internals-docs/predef.md
  * http://ammonite.io/#Configuration
  * http://www.lihaoyi.com/post/ScalaScriptingGettingto10.html
  */
