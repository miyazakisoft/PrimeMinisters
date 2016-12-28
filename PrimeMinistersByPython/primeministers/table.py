#! /usr/bin/env python
# -*- coding: utf-8 -*-

import attributes

class Table(object):
    """表：総理大臣の情報テーブル。"""

    def __init__(self, kind_string):
        """テーブルのコンストラクタ。"""
        self._kind_string = kind_string
        self._attributes = attributes.Attributes(kind_string)
        self._images = []
        self._thumbnails = []
        self._tuples = []

        return

    def __str__(self):
        """自分自身を文字列にして、それを応答する。"""
        a_string = self.__class__.__name__
        a_string += "\n"
        a_string += "attributes:"
        a_string += ",".join(self._attributes.names())
        a_string += "\n"
        a_string += "images:"
        a_string += ",".join(self._images)
        a_string += "\n"
        a_string += "thumbnails:"
        a_string += ",".join(self._thumbnails)
        for tuple in self._tuples:
            a_string += "\n"
            a_string += "tuples:"
            a_string += str(tuple)
        return a_string

    def add(self, tuple):
        """タプルを追加する。"""
        # values = tuple.values()
        # keys = tuple.attributes().keys()
        # if values[keys.index('image')] != '画像':
        self._tuples.append(tuple)
        return

    def attributes(self):
        """属性リストを応答する。"""
        return self._attributes

    def image_filenames(self):
        """画像ファイル群をリストにして応答する。"""
        return self._images

    def thumbnail_filenames(self):
        """縮小画像ファイル群をリストにして応答する。"""
        return self._thumbnails

    def tuples(self):
        """タプル群を応答する。"""
        return self._tuples
