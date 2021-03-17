# dbf4j

dbf4j is a Java library for reading and manipulating dbf database files.
It is a fork of [xBaseJ](https://sourceforge.net/projects/xbasej/) on which
there seems to be no development since at least ~2014.

## Notable changes to xBaseJ

* Replace JCL with SLF4J as the logging framework to support different
  logging backends
* The project has been split into different modules: core, cli and examples.
  The core module contains only the library bits that are published on
  Maven. Module cli has a number of command line tools and can be used to
  launch the Swing/AWT based viewers and manipulation UIs.
  The examples module contains some classes that showcase the usage of the
  library.

## License

This library is released under the terms of the GNU Lesser General Public
License.
