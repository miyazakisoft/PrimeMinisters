#! /usr/bin/env python
# -*- coding: utf-8 -*-

import attributes

class Table(object):
	"""表：総理大臣の情報テーブル。"""

	def __init__(self, kind_string):
		"""テーブルのコンストラクタ。"""


		if kind_string == 'input':
				####
				##
		else :
			



		self._kind_string = kind_string

		self._images = []
		self._thumbnails = []
		self._tuples = []

		return

	def __str__(self):
		"""自分自身を文字列にして、それを応答する。"""

		respondString = self.__class__.__name__



		return respondString

	def add(self, tuple):
		"""タプルを追加する。"""

		tupleValues = tuple.values()
		tupleKeys = tuple.attributes().keys()


		#if values[tupleKeys.index('image')] != '画像':
		#	self._images.append(values[keys.index('image')])
		#	if self._kind_string == 'input':
		#		self._thumbnails.append(values[keys.index('thumbnail')])

		self._tuples.append(tuple)


		return

	def attributes(self):
		"""属性リストを応答する。"""
		return None

	def image_filenames(self):
		"""画像ファイル群をリストにして応答する。"""
		return self._images

	def thumbnail_filenames(self):
		"""縮小画像ファイル群をリストにして応答する。"""



		return self._thumbnails

	def tuples(self):
		"""タプル群を応答する。"""
		return None
