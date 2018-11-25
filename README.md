# nfrum

Nonforum (in Tonsky/Rum) is a real-time discussion forum.

## Overview

Nonforum was created because forums to the present day have not been very interactive or real-time,
despite great progress in web development.

At Nonforum, we wish to promote peace, promote logical thinking, promote emotional clarity, and increase self-awareness and knowledge.

This current version relies on figwheel, and tonsky's rum as well as tonsky's datascript.



## Setup

To get an interactive development environment run:

    lein figwheel

and open your browser at [localhost:3449](http://localhost:3449/).
This will auto compile and send all changes to the browser without the
need to reload. After the compilation process is complete, you will
get a Browser Connected REPL. An easy way to try it is:

    (js/alert "Am I connected?")

and you should see an alert in the browser window.

To clean all compiled files:

    lein clean

To create a production build run:

    lein do clean, cljsbuild once min

And open your browser in `resources/public/index.html`. You will not
get live reloading, nor a REPL.

## License

Copyright © 2014 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.
