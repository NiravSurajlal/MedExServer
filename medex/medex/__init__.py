"""
__init__ for medex project.

Makes the required paths used throughout the project.

"""

from __future__ import absolute_import
from .celery import medex_Celery
import os

__ROOTPATH__ = os.path.abspath(os.path.join(os.path.split(__file__)[0]))

__CACHEPATH__ = os.path.abspath(os.path.join(os.path.split(__file__)[0], 'cache'))
if not os.path.exists(__CACHEPATH__):
    os.mkdir(__CACHEPATH__)

__USERDATCACHEPATH__ = os.path.join(__CACHEPATH__, "user_data")
if not os.path.exists(__USERDATCACHEPATH__):
    os.mkdir(__USERDATCACHEPATH__)
