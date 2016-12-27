#! /usr/bin/env python
# -*- coding: utf-8 -*-

import csv

class IO(object):
	"""入出力：リーダ・ダウンローダ・ライタを抽象する。"""

	def read_csv(self, filename):
		"""指定されたファイルをCSVとして読み込む。"""

		reader_list=[]

    	reader = csv.reader(open(filename, 'r'))
		for row in reader:
			reader_list.append(row)
		return reader_list

	def write_csv(self, filename, rows):
		"""指定されたファイルにCSVとして行たち(rows)を書き出す。"""

		writer = csv.writer(open(filename, 'r'))
		for i in rows:
			writer.writerow(i)
		return
