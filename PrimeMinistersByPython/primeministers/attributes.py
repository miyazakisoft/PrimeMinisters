#! /usr/bin/env python
# -*- coding: utf-8 -*-

class Attributes(object):
	"""属性リスト：総理大臣の情報テーブルを入出力する際の属性情報を記憶。"""

	def __init__(self, kind_string):
		"""入力用("input")または出力用("output")で属性リストを作成するコンストラクタ。"""
        self._keys = []
        self._names = []
        if kind_string == "input":
            self._keys = ["no", "order", "_names", "kana", "period", "school", "party", "image", "thumbnail"]
            self._names = ["人目" , "代" , "氏名" , "ふりがな" ,"在位期間" , "出身校" ,"政党" , "出身地" ,"画像" , "縮小画像"]
        elif kind_string == "output":
            self._keys = ["no", "order", "_names", "kana", "period", "days", "school", "party", "image"]
            self._names = ["人目" , "代" , "氏名" , "ふりがな" ,"在位期間" , "在位日数", "出身校" ,"政党" , "出身地" ,"画像"]
        else:
            print "Error"
		return

	def __str__(self):
		"""自分自身を文字列にして、それを応答する。"""
        a_string = self.__class__.__name__
        a_string += " keys:"
        a_string += ",".join(self._keys)
        a_string += " names:"
        a_string += ",".join(self._nemes)
		return a_string

	def keys(self):
		"""キー群を応答する。"""
		return self._keys

	def names(self):
		"""名前群を応答する。"""
		return self._names

	def set_names(self, names):
		"""名前群を設定する。"""
		return self._names.extend(names)
