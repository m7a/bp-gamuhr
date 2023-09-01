---
section: 32
x-masysma-name: gamuhr
title: GAM Uhr
date: 2020/02/14 15:21:50
lang: en-US
author: ["Linux-Fan, Ma_Sys.ma (Ma_Sys.ma@web.de)"]
keywords: ["gam", "uhr", "java"]
x-masysma-version: 1.0.0
x-masysma-repository: https://www.github.com/m7a/bp-gamuhr
x-masysma-website: https://masysma.net/32/gamuhr.xhtml
x-masysma-owned: 1
x-masysma-copyright: |
  Copyright (c) 2017, 2020 Ma_Sys.ma.
  For further info send an e-mail to Ma_Sys.ma@web.de.
---
Description
===========

The _GAM UHR_ provides a simple on-going time counter in the style of a
7-segment clock. It is intended to be visible upon a quick glance and hence
shows large segments.

One possible use is keeping track of ongoing game times, hence the prefix _GAM_.
The only interface element provided is a pause button to temporarily halt the
ongoing time counter.

Note: This program does not attempt to achieve maximum precision. In the long
run, it should display time equivalent to the difference between the times
measured by the OS. Internally, it uses `System.currentTimeMillis()` and
absolute times. Changes in OS time may make the clock jump!

![GAM UHR screenshot](gamuhr_att/scr.png)

Compilation can be performed with `ant jar`.

See also: [tty-clock(1)](https://manpages.debian.org/buster/tty-clock/tty-clock.1.en.html)
