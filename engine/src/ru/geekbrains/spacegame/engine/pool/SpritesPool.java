package ru.geekbrains.spacegame.engine.pool;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

import ru.geekbrains.spacegame.engine.Sprite;

/**
 * Created by Igor Prus on 13-Feb-18.
 */

public abstract class SpritesPool <T extends Sprite>{
    protected final List<T> activeObjects = new ArrayList<T>();
    protected final List<T> freeObjects = new ArrayList<T>();

    protected abstract T newObject();

    public T obtain(){
        T object;
        if (freeObjects.isEmpty()) {
            object = newObject();
        } else {
            object = freeObjects.remove(freeObjects.size() - 1);
        }
        activeObjects.add(object);
        return object;
    }

    public void drawActiveObjects(SpriteBatch batch){
        for (int i = 0; i < activeObjects.size(); i++) {
            activeObjects.get(i).draw(batch);
        }
    }

    public void updateActiveObjects(float delta){
       for (int i = 0; i < activeObjects.size(); i++) {
           activeObjects.get(i).update(delta);
       }
    }

    public void  freeAllDestroyedActiveObjects() {
        for (int i = 0; i < activeObjects.size(); i++) {
            T sprite = activeObjects.get(i);
            if (sprite.isDestroyed()){
                free(sprite);
                i--;
                sprite.setDestroyed(false);
            }
        }
    }

    public void free(T object) {
        if (!activeObjects.remove(object)) {
            throw new RuntimeException("Trying to remove unexisting object");
        }
        freeObjects.add(object);
    }

    protected void dispose() {
        activeObjects.clear();
        freeObjects.clear();
    }

}
