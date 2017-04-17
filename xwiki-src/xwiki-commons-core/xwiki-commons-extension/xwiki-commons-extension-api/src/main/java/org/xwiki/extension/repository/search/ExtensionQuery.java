/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.extension.repository.search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * A query to an extension repository.
 * 
 * @version $Id: 5af22c7e170f583a271af41a812636819409b36c $
 * @since 7.0M2
 */
public class ExtensionQuery
{
    /**
     * The order in which extensions should be sorted.
     * 
     * @version $Id: 5af22c7e170f583a271af41a812636819409b36c $
     */
    public enum ORDER
    {
        /**
         * Descending order.
         */
        DESC,

        /**
         * Ascending order.
         */
        ASC;
    }

    /**
     * The comparison to apply.
     * 
     * @version $Id: 5af22c7e170f583a271af41a812636819409b36c $
     */
    public enum COMPARISON
    {
        /**
         * The value is the same than the filter one.
         */
        EQUAL,

        /**
         * The value contains what is in the filter.
         */
        MATCH;
    }

    /**
     * The sort criteria.
     * 
     * @version $Id: 5af22c7e170f583a271af41a812636819409b36c $
     */
    public static class SortClause
    {
        private final String field;

        private final ORDER order;

        /**
         * @param field the name of the field
         * @param order the order in which extensions should be sorted
         */
        public SortClause(String field, ORDER order)
        {
            this.field = field;
            this.order = order;
        }

        /**
         * @return the name of the field
         */
        public String getField()
        {
            return this.field;
        }

        /**
         * @return the order in which extensions should be sorted.
         */
        public ORDER getOrder()
        {
            return this.order;
        }
    }

    /**
     * A filter to apply on an extension field.
     * 
     * @version $Id: 5af22c7e170f583a271af41a812636819409b36c $
     */
    public static class Filter
    {
        private final String field;

        private final Object value;

        private final COMPARISON comparison;

        /**
         * @param field the name of the field
         * @param value the value to compare to
         * @param comparison the comparison to apply
         */
        public Filter(String field, Object value, COMPARISON comparison)
        {
            this.field = field;
            this.value = value;
            this.comparison = comparison;
        }

        /**
         * @return the name of the field
         */
        public String getField()
        {
            return this.field;
        }

        /**
         * @return the value to compare to
         */
        public Object getValue()
        {
            return this.value;
        }

        /**
         * @return the comparison to apply
         */
        public COMPARISON getComparison()
        {
            return this.comparison;
        }

        @Override
        public String toString()
        {
            StringBuilder builder = new StringBuilder();

            builder.append(getField());
            builder.append(' ');
            builder.append(getComparison());
            builder.append(' ');
            builder.append(getValue());

            return builder.toString();
        }
    }

    private String query;

    private int limit = -1;

    private int offset;

    private List<SortClause> sortClauses = new ArrayList<>();

    private List<Filter> filters = new ArrayList<>();

    /**
     * No filtering. Usually return everything.
     */
    public ExtensionQuery()
    {
    }

    /**
     * @param query the query to execute
     */
    public ExtensionQuery(String query)
    {
        this.query = query;
    }

    /**
     * @param query the query to duplicate
     */
    public ExtensionQuery(ExtensionQuery query)
    {
        this.query = query.getQuery();

        setOffset(query.getOffset());
        setLimit(query.getLimit());

        setSortClauses(query.getSortClauses());
        setFilters(query.getFilters());
    }

    /**
     * @return the query statement
     */
    public String getQuery()
    {
        return this.query;
    }

    /**
     * @param limit the number of results to return when querying extensions
     * @return this query.
     */
    public ExtensionQuery setLimit(int limit)
    {
        this.limit = limit;

        return this;
    }

    /**
     * @param offset offset of query result to set (skip first "offset" rows).
     * @return this query.
     */
    public ExtensionQuery setOffset(int offset)
    {
        this.offset = offset;

        return this;
    }

    /**
     * @return the filters
     */
    public List<Filter> getFilters()
    {
        return this.filters;
    }

    /**
     * @param filters the filters
     * @return this
     */
    public ExtensionQuery setFilters(Collection<Filter> filters)
    {
        this.filters = new ArrayList<>(filters);

        return this;
    }

    /**
     * @param field the name of the field
     * @param value the value to compare to
     * @param comparison the comparison to apply
     * @return this
     */
    public ExtensionQuery addFilter(String field, Object value, COMPARISON comparison)
    {
        this.filters.add(new Filter(field, value, comparison));

        return this;
    }

    /**
     * @param newFilters the filters to add
     * @return this
     * @since 8.3RC1
     */
    public ExtensionQuery addFilters(List<Filter> newFilters)
    {
        this.filters.addAll(newFilters);

        return this;
    }

    /**
     * @return the criteria used to sort the result
     */
    public List<SortClause> getSortClauses()
    {
        return this.sortClauses;
    }

    /**
     * @param sortClauses the criteria used to sort the result
     * @return this
     */
    public ExtensionQuery setSortClauses(Collection<SortClause> sortClauses)
    {
        this.sortClauses = new ArrayList<>(sortClauses);

        return this;
    }

    /**
     * @param field the name of the field
     * @param order the order in which extensions should be sorted
     * @return this
     */
    public ExtensionQuery addSort(String field, ORDER order)
    {
        this.sortClauses.add(new SortClause(field, order));

        return this;
    }

    /**
     * @return limit limit of result list.
     * @see #setLimit(int)
     */
    public int getLimit()
    {
        return this.limit;
    }

    /**
     * @return offset offset of query result.
     * @see #setOffset(int)
     */
    public int getOffset()
    {
        return this.offset;
    }
}
