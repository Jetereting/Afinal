/**
 * Copyright (c) 2012-2013, Michael Yang 杨福海 (www.yangfuhai.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package us.eiyou.afinal.bitmap.core;

import android.graphics.Bitmap;

import us.eiyou.afinal.utils.Utils;

public class BaseMemoryCacheImpl implements IMemoryCache {

	private final LruMemoryCache<String, Bitmap> mMemoryCache;
	
	public BaseMemoryCacheImpl(int size) {
		mMemoryCache = new LruMemoryCache<String, Bitmap>(size) {
             @Override
             protected int sizeOf(String key, Bitmap bitmap) {
                 return Utils.getBitmapSize(bitmap);
             }
         }; 
	}
	
	@Override
	public void put(String key, Bitmap bitmap) {
		mMemoryCache.put(key, bitmap);
	}

	@Override
	public Bitmap get(String key) {
		return mMemoryCache.get(key);
	}

	@Override
	public void evictAll() {
		mMemoryCache.evictAll();
	}

	@Override
	public void remove(String key) {
		mMemoryCache.remove(key);
	}


}
