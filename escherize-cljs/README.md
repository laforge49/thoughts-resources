# Using Boot with Reagent

This project is taken directly from a great
[tutorial on Boot and Reagent](http://escherize.com/2016/02/29/boot-with-cljs/).

First I created the project:
```
boot -d seancorfield/boot-new new -t tenzing -a +reagent -n escherize-cljs
cd escherize-cljs
```

I made a small change to the
[build.boot file](https://github.com/laforge49/thoughts-resources/blob/master/escherize-cljs/build.boot),
adding a prod task.
After running "boot prod", I published the target directory:
http://rolonicark.github.io/escherize-cljs/
