#!/usr/bin/env bash

# ---------------------------------------------------------------------- */
# Builds all Gradle Projects - 5/31/2017
#
# -- Run as gradle task as $ gradle build
#
# ---------------------------------------------------------------------- */

gradle clean

function printHeader
{
	echo
	echo "NOW BUILDING PROJECT [:$1] --------------------------------------*/"
	echo
}


printHeader "CONFIG"
gradle config:build

printHeader "CORE"
gradle core:build

printHeader "POSTS"
gradle posts:build

printHeader "EUREKA"
gradle eureka:build

