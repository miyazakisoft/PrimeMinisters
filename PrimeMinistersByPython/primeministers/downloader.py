#! /usr/bin/env python
# -*- coding: utf-8 -*-

import os
import shutil
import urllib

import io
import reader

class Downloader(io.IO):
    """ダウンローダ：総理大臣のCSVファイル・画像ファイル・サムネイル画像ファイルをダウンロードする。"""

    def __init__(self, base_directory):
        """ダウンローダのコンストラクタ。"""
        self._base_directory = base_directory
        self._url = "http://www.cc.kyoto-su.ac.jp/~atsushi/Programs/VisualWorks/CSV2HTML/PrimeMinisters/"
        return

    def download_all(self):
        """すべて（総理大臣の情報を記したCSVファイル・画像ファイル群・縮小画像ファイル群）をダウンロードし、テーブルを応答する。"""
        if os.path.isdir(self._base_directory+"images"):
            shutil.rmtree(self._base_directory+"images")
        os.makedirs(self._base_directory+"images")
        if os.path.isdir(self._base_directory+"thumbnails"):
            shutil.rmtree(self._base_directory+"thumbnails")
        os.makedirs(self._base_directory+"thumbnails")

        self.download_csv()
        a_reader = reader.Reader(self._base_directory + "PrimeMinisters.csv")
        a_table = a_reader.table()

        image_names = a_table.image_filenames()
        self.download_images(image_names)
        thumbnails_names = a_table.thumbnail_filenames()
        self.download_images(thumbnails_names)

        return a_table

    def download_csv(self):
        """総理大臣の情報を記したCSVファイルをダウンロードする。"""
        url = self._url+"PrimeMinisters.csv"
        csv = urllib.urlopen(url)
        if csv.code != 200:
            return
        with open(self._base_directory + "PrimeMinisters.csv", "wb") as csv_file:
            shutil.copyfileobj(csv, csv_file)

        return None

    def download_images(self, image_filenames):
        """画像ファイル群または縮小画像ファイル群をダウンロードする。"""
        for filename in image_filenames:
            url = self._url+filename
            image = urllib.urlopen(url)
            if image.code != 200:
                return
            with open(self._base_directory + filename, "wb") as image_file:
                shutil.copyfileobj(image, image_file)
            image.close()
        return
