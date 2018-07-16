package br.com.developers.allefsousa.architecturecomponents;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by allef on 15/07/2018.
 */
@Dao
public interface DaoCliente {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void post(Cliente cliente);


    @Query("DELETE FROM cliente_table")
    void deleteAll();

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    LiveData<List<Cliente>> getAll();








}
