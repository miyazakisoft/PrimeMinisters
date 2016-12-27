#! /usr/bin/env python
# -*- coding: utf-8 -*-

import sys
#sys.path.append('./primeministers')
import primeministers.example

if __name__ == "__main__":
	an_example = primeministers.example.Example()
	sys.exit(an_example.main())
